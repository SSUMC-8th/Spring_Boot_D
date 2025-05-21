package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewId is a Querydsl query type for ReviewId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QReviewId extends BeanPath<ReviewId> {

    private static final long serialVersionUID = -226435265L;

    public static final QReviewId reviewId1 = new QReviewId("reviewId1");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> restaurantId = createNumber("restaurantId", Long.class);

    public final NumberPath<Long> reviewId = createNumber("reviewId", Long.class);

    public QReviewId(String variable) {
        super(ReviewId.class, forVariable(variable));
    }

    public QReviewId(Path<? extends ReviewId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewId(PathMetadata metadata) {
        super(ReviewId.class, metadata);
    }

}

