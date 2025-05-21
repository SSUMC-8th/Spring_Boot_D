package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthdate = createDate("birthdate", java.time.LocalDate.class);

    public final DateTimePath<java.time.Instant> createdAt = createDateTime("createdAt", java.time.Instant.class);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.Instant> inactiveDate = createDateTime("inactiveDate", java.time.Instant.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> phoneNum = createNumber("phoneNum", Integer.class);

    public final StringPath platform = createString("platform");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<PreferredFood, QPreferredFood> preferredFoodList = this.<PreferredFood, QPreferredFood>createList("preferredFoodList", PreferredFood.class, QPreferredFood.class, PathInits.DIRECT2);

    public final ListPath<ReviewPhoto, QReviewPhoto> reviewPhotos = this.<ReviewPhoto, QReviewPhoto>createList("reviewPhotos", ReviewPhoto.class, QReviewPhoto.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public final StringPath specAddress = createString("specAddress");

    public final StringPath status = createString("status");

    public final DateTimePath<java.time.Instant> updatedAt = createDateTime("updatedAt", java.time.Instant.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

