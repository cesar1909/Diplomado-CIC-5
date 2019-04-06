package mx.ipn.cic.webserviceexample.networking;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.ipn.cic.webserviceexample.MainActivity;
import mx.ipn.cic.webserviceexample.model.UserModel;
import mx.ipn.cic.webserviceexample.util.Constants;

public class NetworkingManager {

    private static NetworkingManager instance;
    private static String TAG = NetworkingManager.class.getName();
    private final RequestQueue volleyQueue;

    public static NetworkingManager getInstance() {

        if (instance == null) {
            instance = new NetworkingManager();
        }

        return instance;
    }

    private NetworkingManager() {

        this.volleyQueue =
                Volley.newRequestQueue(MainActivity.instance);

    }

    public void getAll(final INetworkingListener listener) {

        JsonArrayRequest request =
                new JsonArrayRequest(
                        Request.Method.GET, //Método http a ejecutar
                        Constants.ALL_USERS, //Endpoint
                        null, //Body a enviar
                        new Response.Listener<JSONArray>() { //Método callback de éxito
                            @Override
                            public void onResponse(JSONArray response) {

                                //TODO Generar Objetos de dominio

                                List<UserModel> list = new ArrayList<>();
                                for (int i = 0; i < response.length(); i++) {

                                    try {

                                        JSONObject json = response.getJSONObject(i);

                                        UserModel user = new UserModel(
                                                json.getInt("id"),
                                                json.getString("name"),
                                                json.getString("lastname"),
                                                json.getInt("age"),
                                                json.getString("mainAddress")
                                        );

                                        list.add(user);

                                    } catch (JSONException e) {

                                    }

                                }

                                //Log.i(TAG, response.toString());

                                listener.onSuccess(list);

                            }
                        },
                        new Response.ErrorListener() { //Método callback de error
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.e(TAG, error.getMessage());
                                listener.onError(error.getMessage());

                            }
                        }
                ) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {

                        Map<String, String> headers = new HashMap<>();
                        headers.put("Content-Type", "application/json");

                        return headers;
                    }
                };

        this.volleyQueue.add(request); //Se ejecuta el consumo del WS

    }
}











