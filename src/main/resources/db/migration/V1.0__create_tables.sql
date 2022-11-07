CREATE TABLE orders
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    ordered_by VARCHAR(255)          NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);
CREATE TABLE products
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    name   VARCHAR(255)          NOT NULL,
    weight DOUBLE                NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);
