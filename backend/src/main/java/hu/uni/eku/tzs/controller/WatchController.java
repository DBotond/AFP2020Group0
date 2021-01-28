package hu.uni.eku.tzs.controller;
import hu.uni.eku.tzs.controller.dto.WatchDto;
import hu.uni.eku.tzs.controller.dto.WatchRecordRequestDto;
import hu.uni.eku.tzs.model.Watch;
import hu.uni.eku.tzs.service.WatchService;
import hu.uni.eku.tzs.service.exceptions.WatchAlreadyExistException;
import hu.uni.eku.tzs.service.exceptions.WatchNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/watch")
@RequiredArgsConstructor
@Api(tags = "Watch")
@Slf4j
public class WatchController {
    private final WatchService service;

    @PostMapping(value = "/record")
    @ApiOperation(value = "Record watch")
    public void record(@RequestBody WatchRecordRequestDto request)
    {
        log.info("Recording new Watch ({})", request.getBalance());
        try
        {
            service.record(new Watch(
                    0,
                    request.getBalance()
            ));
        }
        catch (WatchAlreadyExistException e) {
            log.info("Watch ({}) already exists! Message: {}", request.getBalance(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Watch list")
    public Collection<WatchDto> query()
    {
        return service.readAll().stream().map(model ->
                WatchDto.builder()
                        .id(model.getId())
                        .balance(model.getBalance())
                        .build()).collect(Collectors.toList());
    }

    @DeleteMapping(value = {"/delete/{id}"})
    @ApiOperation(value = "Delete a watch")
    public void delete(@PathVariable int id)
    {
        try
        {
            log.info("Watch successfully deleted with this id: {}",id);
            service.delete(id);
        }
        catch (WatchNotFoundException e)
        {
            log.info("Watch Not Found with this id: ({})",id);
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
