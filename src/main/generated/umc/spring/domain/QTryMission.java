package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTryMission is a Querydsl query type for TryMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTryMission extends EntityPathBase<TryMission> {

    private static final long serialVersionUID = 989190397L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTryMission tryMission = new QTryMission("tryMission");

    public final NumberPath<Long> certificationNum = createNumber("certificationNum", Long.class);

    public final DateTimePath<java.time.Instant> createdAt = createDateTime("createdAt", java.time.Instant.class);

    public final QTryMissionId id;

    public final QMember member;

    public final QMission mission;

    public final StringPath status = createString("status");

    public final DateTimePath<java.time.Instant> updatedAt = createDateTime("updatedAt", java.time.Instant.class);

    public QTryMission(String variable) {
        this(TryMission.class, forVariable(variable), INITS);
    }

    public QTryMission(Path<? extends TryMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTryMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTryMission(PathMetadata metadata, PathInits inits) {
        this(TryMission.class, metadata, inits);
    }

    public QTryMission(Class<? extends TryMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QTryMissionId(forProperty("id")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

