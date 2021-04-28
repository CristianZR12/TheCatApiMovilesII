package memento.example.thecatmvibreeds.room

import memento.example.thecatmvibreeds.model.Cat
import memento.example.thecatmvibreeds.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():EntityMapper<Cat, CatCacheEntity> {
    override fun mapFromEntity(entity: Cat): CatCacheEntity {
        return CatCacheEntity(
                id = entity.id,
                name = entity.name,
                description = entity.description
        )
    }

    override fun mapToEntity(domainObject: CatCacheEntity): Cat {
        return Cat(
                id = domainObject.id,
                name = domainObject.name,
                description = domainObject.description
        )
    }

    fun mapToListEntity(domainObjects:List<CatCacheEntity>):List<Cat> {
        return domainObjects.map { mapToEntity(it) }
    }

}