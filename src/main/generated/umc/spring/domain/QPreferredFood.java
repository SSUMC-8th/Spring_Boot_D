package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferredFood is a Querydsl query type for PreferredFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferredFood extends EntityPathBase<PreferredFood> {

    private static final long serialVersionUID = -780657837L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferredFood preferredFood = new QPreferredFood("preferredFood");

    public final DateTimePath<java.time.Instant> createdAt = createDateTime("createdAt", java.time.Instant.class);

    public final QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final DateTimePath<java.time.Instant> updatedAt = createDateTime("updatedAt", java.time.Instant.class);

    public QPreferredFood(String variable) {
        this(PreferredFood.class, forVariable(variable), INITS);
    }

    public QPreferredFood(Path<? extends PreferredFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferredFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferredFood(PathMetadata metadata, PathInits inits) {
        this(PreferredFood.class, metadata, inits);
    }

    public QPreferredFood(Class<? extends PreferredFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new QFoodCategory(forProperty("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

