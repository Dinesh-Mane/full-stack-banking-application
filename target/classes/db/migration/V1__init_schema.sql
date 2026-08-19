-- =====================================================================
-- V1__init_schema.sql
-- Flyway migration: initial schema (users, accounts)
--
-- NAMING CONVENTION (important, Flyway is strict about this):
--   V<version>__<description>.sql   (TWO underscores after the version)
--   Once this file is applied to any environment, NEVER edit it again.
--   Any change = a NEW migration file (V2__..., V3__...).
--   This is what makes migrations safe across dev/staging/prod.
-- =====================================================================

-- ---------- USERS ----------
CREATE TABLE users (
    id              BIGSERIAL PRIMARY KEY,
    full_name       VARCHAR(150)        NOT NULL,
    email           VARCHAR(255)        NOT NULL,
    password_hash   VARCHAR(255)        NOT NULL,
    role            VARCHAR(20)         NOT NULL DEFAULT 'CUSTOMER',
    kyc_status      VARCHAR(20)         NOT NULL DEFAULT 'PENDING',
    enabled         BOOLEAN             NOT NULL DEFAULT TRUE,
    created_at      TIMESTAMP           NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP           NOT NULL DEFAULT now(),

    CONSTRAINT uq_users_email UNIQUE (email),
    CONSTRAINT chk_users_role CHECK (role IN ('CUSTOMER', 'ADMIN', 'TELLER')),
    CONSTRAINT chk_users_kyc_status CHECK (kyc_status IN ('PENDING', 'VERIFIED', 'REJECTED'))
);

-- Email is how we'll look up users on every login -> needs an index.
-- (UNIQUE constraint above already creates one implicitly in Postgres,
--  but being explicit here documents the intent for future readers.)
CREATE INDEX idx_users_email ON users (email);


-- ---------- ACCOUNTS ----------
CREATE TABLE accounts (
    id              BIGSERIAL PRIMARY KEY,
    account_number  VARCHAR(20)         NOT NULL,
    user_id         BIGINT              NOT NULL,
    account_type    VARCHAR(20)         NOT NULL,
    balance         NUMERIC(19,4)       NOT NULL DEFAULT 0.0000,
    status          VARCHAR(20)         NOT NULL DEFAULT 'ACTIVE',
    version         BIGINT              NOT NULL DEFAULT 0,   -- optimistic locking (used from Phase 5)
    created_at      TIMESTAMP           NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP           NOT NULL DEFAULT now(),

    CONSTRAINT uq_accounts_account_number UNIQUE (account_number),
    CONSTRAINT fk_accounts_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT chk_accounts_type CHECK (account_type IN ('SAVINGS', 'CURRENT')),
    CONSTRAINT chk_accounts_status CHECK (status IN ('ACTIVE', 'FROZEN', 'CLOSED')),
    CONSTRAINT chk_accounts_balance_non_negative CHECK (balance >= 0)
);

-- We will constantly query "give me all accounts for this user" (dashboard)
-- and "find account by account_number" (transfers) -> both need indexes.
CREATE INDEX idx_accounts_user_id ON accounts (user_id);
CREATE INDEX idx_accounts_account_number ON accounts (account_number);
