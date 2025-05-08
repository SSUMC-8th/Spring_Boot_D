package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthentication is a Querydsl query type for Authentication
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthentication extends EntityPathBase<Authentication> {

    private static final long serialVersionUID = -598014428L;

    public static final QAuthentication authentication = new QAuthentication("authentication");

    public final umc.spring.domain.common.QBase _super = new umc.spring.domain.common.QBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath provider = createString("provider");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAuthentication(String variable) {
        super(Authentication.class, forVariable(variable));
    }

    public QAuthentication(Path<? extends Authentication> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthentication(PathMetadata metadata) {
        super(Authentication.class, metadata);
    }

}

