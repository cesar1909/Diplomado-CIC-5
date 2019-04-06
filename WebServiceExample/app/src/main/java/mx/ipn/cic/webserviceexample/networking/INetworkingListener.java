package mx.ipn.cic.webserviceexample.networking;

public interface INetworkingListener {

    void onSuccess(Object result);

    void onError(String error);

}
