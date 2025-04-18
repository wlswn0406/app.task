package app.task.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    @Builder.Default
    private boolean success = false;
    private String message;
    private T data;

    public enum ApiMessage {
        SUCCESS, ERROR, DATA_NOT_FOUND, INVALID_REQUEST;
    }

    /**
     * 성공 응답을 생성하는 메소드
     *
     * @param data 응답에 포함할 데이터 객체
     * @param message 응답에 포함할 성공 메시지
     * @return 성공 상태와 메시지가 포함된 API 응답 객체
     */
    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }
    
    /**
     * 성공 응답을 생성하는 메소드
     *
     * @param data 응답에 포함할 데이터 객체
     * @return 성공 상태와 데이터가 포함된 API 응답 객체
     */
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(ApiMessage.SUCCESS.name())
                .data(data)
                .build();
    }

    /**
     * 성공 응답을 생성하는 메소드
     *
     * @param message 응답에 포함할 성공 메시지
     * @return 성공 상태와 메시지가 포함된 API 응답 객체
     */
    public static <T> ApiResponse<T> success(String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(null)
                .build();
    }

    /**
     * 오류 응답을 생성하는 메소드
     *
     * @param message 오류 메시지
     * @return 실패 상태와 오류 메시지가 포함된 API 응답 객체
     */
    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .build();
    }

}