package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTryMissionId is a Querydsl query type for TryMissionId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QTryMissionId extends BeanPath<TryMissionId> {

    private static final long serialVersionUID = 1424201464L;

    public static final QTryMissionId tryMissionId1 = new QTryMissionId("tryMissionId1");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> missionId = createNumber("missionId", Long.class);

    public final NumberPath<Long> tryMissionId = createNumber("tryMissionId", Long.class);

    public QTryMissionId(String variable) {
        super(TryMissionId.class, forVariable(variable));
    }

    public QTryMissionId(Path<? extends TryMissionId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTryMissionId(PathMetadata metadata) {
        super(TryMissionId.class, metadata);
    }

}

