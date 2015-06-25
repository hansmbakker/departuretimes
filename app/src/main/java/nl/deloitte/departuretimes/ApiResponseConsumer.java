package nl.deloitte.departuretimes;

public interface ApiResponseConsumer {

    void HandleError(String error);

    void HandleDownloadResponse(String response);
}
