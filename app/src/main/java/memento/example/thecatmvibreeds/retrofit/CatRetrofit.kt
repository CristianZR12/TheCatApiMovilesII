package memento.example.thecatmvibreeds.retrofit

import retrofit2.http.GET

interface CatRetrofit {
    @GET("breeds")
    suspend fun getCats():List<CatNetworkEntity>
}