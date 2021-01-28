package hu.uni.eku.tzs.controller.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WatchDto {
    private int id;
    private int balance;
}