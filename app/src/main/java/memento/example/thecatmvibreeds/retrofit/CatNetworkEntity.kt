package memento.example.thecatmvibreeds.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatNetworkEntity(
    @SerializedName("id")
    @Expose
    var id:String,

    @SerializedName("name")
    @Expose
    var name:String,

    @SerializedName("description")
    @Expose
    var description:String
)