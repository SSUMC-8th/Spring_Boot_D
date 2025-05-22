package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMissionId is a Querydsl query type for MissionId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMissionId extends BeanPath<MissionId> {

    private static final long serialVersionUID = -1973643109L;

    public static final QMissionId missionId1 = new QMissionId("missionId1");

    public final NumberPath<Long> missionId = createNumber("missionId", Long.class);

    public final NumberPath<Long> restaurantId = createNumber("restaurantId", Long.class);

    public QMissionId(String variable) {
        super(MissionId.class, forVariable(variable));
    }

    public QMissionId(Path<? extends MissionId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMissionId(PathMetadata metadata) {
        super(MissionId.class, metadata);
    }

}

