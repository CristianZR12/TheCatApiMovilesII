package memento.example.thecatmvibreeds.retrofit

import memento.example.thecatmvibreeds.model.Cat
import memento.example.thecatmvibreeds.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor():EntityMapper<Cat, CatNetworkEntity> {
    override fun mapFromEntity(entity: Cat): CatNetworkEntity {
        return CatNetworkEntity(
            id = entity.id,
            name = entity.name,
            description = entity.description
        )
    }

    override fun mapToEntity(domainObject: CatNetworkEntity): Cat {
        return Cat(
            id = domainObject.id,
            name = domainObject.name,
            description = domainObject.description
        )
    }

    fun mapToEntityList(domainObjects:List<CatNetworkEntity>):List<Cat> {
        return domainObjects.map { mapToEntity(it) }
    }

}