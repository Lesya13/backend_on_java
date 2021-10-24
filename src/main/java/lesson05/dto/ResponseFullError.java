package lesson05.dto;

import lombok.*;

@Data
public class ResponseFullError extends ResponseError {
    String error;
    String path;
}
