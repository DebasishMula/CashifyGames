package Apis;

import java.util.List;

import PojoClasses.RetroPhoto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
