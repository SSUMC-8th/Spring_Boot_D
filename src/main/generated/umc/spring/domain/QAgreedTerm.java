package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAgreedTerm is a Querydsl query type for AgreedTerm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAgreedTerm extends EntityPathBase<AgreedTerm> {

    private static final long serialVersionUID = -783672976L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAgreedTerm agreedTerm = new QAgreedTerm("agreedTerm");

    public final DateTimePath<java.time.Instant> createdAt = createDateTime("createdAt", java.time.Instant.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QTerm terms;

    public final DateTimePath<java.time.Instant> updatedAt = createDateTime("updatedAt", java.time.Instant.class);

    public QAgreedTerm(String variable) {
        this(AgreedTerm.class, forVariable(variable), INITS);
    }

    public QAgreedTerm(Path<? extends AgreedTerm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAgreedTerm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAgreedTerm(PathMetadata metadata, PathInits inits) {
        this(AgreedTerm.class, metadata, inits);
    }

    public QAgreedTerm(Class<? extends AgreedTerm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.terms = inits.isInitialized("terms") ? new QTerm(forProperty("terms")) : null;
    }

}

