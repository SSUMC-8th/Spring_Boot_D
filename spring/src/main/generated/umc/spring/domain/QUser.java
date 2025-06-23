package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1348045193L;

    public static final QUser user = new QUser("user");

    public final umc.spring.domain.common.QBase _super = new umc.spring.domain.common.QBase(this);

    public final StringPath address = createString("address");

    public final ListPath<Authentication, QAuthentication> authentications = this.<Authentication, QAuthentication>createList("authentications", Authentication.class, QAuthentication.class, PathInits.DIRECT2);

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> points = createNumber("points", Integer.class);

    public final ListPath<FoodCategory, QFoodCategory> preferCategory = this.<FoodCategory, QFoodCategory>createList("preferCategory", FoodCategory.class, QFoodCategory.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.Role> role = createEnum("role", umc.spring.domain.enums.Role.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.domain.mapping.UserMission, umc.spring.domain.mapping.QUserMission> userMissions = this.<umc.spring.domain.mapping.UserMission, umc.spring.domain.mapping.QUserMission>createList("userMissions", umc.spring.domain.mapping.UserMission.class, umc.spring.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.UserTerms, umc.spring.domain.mapping.QUserTerms> userTerms = this.<umc.spring.domain.mapping.UserTerms, umc.spring.domain.mapping.QUserTerms>createList("userTerms", umc.spring.domain.mapping.UserTerms.class, umc.spring.domain.mapping.QUserTerms.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

