import dev.eduayuso.cleansamples.shared.domain.entities.IEntity

interface IRepository<KeyType, E: IEntity> {

    suspend fun getById(id: KeyType): E?
    suspend fun getAll(): List<E>
    suspend fun insert(entity: E): E?
    suspend fun update(entity: E): E?
    suspend fun delete(entity: E): Boolean
}