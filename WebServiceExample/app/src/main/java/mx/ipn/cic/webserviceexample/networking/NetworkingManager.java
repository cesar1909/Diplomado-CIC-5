package mx.ipn.cic.webserviceexample.networking;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
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

                                List<UserModel> list = new ArrayList<>();
                                for (int i = 0; i < response.length(); i++) {

                                    try {

                                        JSONObject json = response.getJSONObject(i);

                                        UserModel user = new UserModel(
                                                json.getString("_id"),
                                                json.getString("name"),
                                                json.getString("lastname"),
                                                json.getInt("age"),
                                                json.getString("address")
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
                        headers.put("Authorization", "Basic a2lkX1NrbU5uS1VLTjo5N2I2YTk4Y2FhZDA0ZDg0ODdkZGVlMjY2ZTc3NmNkMQ==");

                        return headers;
                    }
                };

        this.volleyQueue.add(request); //Se ejecuta el consumo del WS

    }

    public void delete(UserModel user,
                       final INetworkingListener listener) {

        String url = Constants.DELETE_USER.replace("{USER_ID}", user.getId());

        StringRequest request = new StringRequest(
                Request.Method.DELETE,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.i(TAG, response);

                        try {

                            JSONObject json = new JSONObject(response);
                            int count = json.getInt("count");

                            listener.onSuccess(count);

                        } catch (JSONException e) {
                            e.printStackTrace();

                            listener.onError("Ocurrió un error al consumir el WS");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        listener.onError(error.getMessage());

                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Basic a2lkX1NrbU5uS1VLTjo5N2I2YTk4Y2FhZDA0ZDg0ODdkZGVlMjY2ZTc3NmNkMQ==");

                return headers;
            }
        };

        this.volleyQueue.add(request);

    }

    public void update(UserModel user, final INetworkingListener listener) {

        String url = Constants.UPDATE_USER.replace("{USER_ID}", user.getId());

        JSONObject jsonRequest = new JSONObject();
        try {

            //Se arma la estructura JSON a enviar para la actualización.
            jsonRequest.put("name", user.getName());
            jsonRequest.put("lastname", user.getLastname());
            jsonRequest.put("age", user.getAge());
            jsonRequest.put("address", user.getMainAddress());

        } catch (JSONException e) {
            listener.onError(e.getMessage());

            return;
        }

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                url,
                jsonRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        listener.onSuccess("Actualización exitosa.");

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        listener.onError(error.getMessage());

                    }
                }
        ) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Basic a2lkX1NrbU5uS1VLTjo5N2I2YTk4Y2FhZDA0ZDg0ODdkZGVlMjY2ZTc3NmNkMQ==");

                return headers;
            }
        };

        volleyQueue.add(request);

    }
}











