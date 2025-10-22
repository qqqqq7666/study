package com.sparta_msa.product.adapter.out.persistence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJpaProduct is a Querydsl query type for JpaProduct
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJpaProduct extends EntityPathBase<JpaProduct> {

    private static final long serialVersionUID = 1167907723L;

    public static final QJpaProduct jpaProduct = new QJpaProduct("jpaProduct");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final EnumPath<com.sparta_msa.product.core.domain.ProductStatus> status = createEnum("status", com.sparta_msa.product.core.domain.ProductStatus.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QJpaProduct(String variable) {
        super(JpaProduct.class, forVariable(variable));
    }

    public QJpaProduct(Path<? extends JpaProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJpaProduct(PathMetadata metadata) {
        super(JpaProduct.class, metadata);
    }

}

