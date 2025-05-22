package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOpenHour is a Querydsl query type for OpenHour
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOpenHour extends EntityPathBase<OpenHour> {

    private static final long serialVersionUID = -470241286L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOpenHour openHour1 = new QOpenHour("openHour1");

    public final TimePath<java.time.LocalTime> closeHour = createTime("closeHour", java.time.LocalTime.class);

    public final DateTimePath<java.time.Instant> createdAt = createDateTime("createdAt", java.time.Instant.class);

    public final StringPath day = createString("day");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final TimePath<java.time.LocalTime> openHour = createTime("openHour", java.time.LocalTime.class);

    public final QRestaurant restaurant;

    public final DateTimePath<java.time.Instant> updatedAt = createDateTime("updatedAt", java.time.Instant.class);

    public QOpenHour(String variable) {
        this(OpenHour.class, forVariable(variable), INITS);
    }

    public QOpenHour(Path<? extends OpenHour> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOpenHour(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOpenHour(PathMetadata metadata, PathInits inits) {
        this(OpenHour.class, metadata, inits);
    }

    public QOpenHour(Class<? extends OpenHour> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

