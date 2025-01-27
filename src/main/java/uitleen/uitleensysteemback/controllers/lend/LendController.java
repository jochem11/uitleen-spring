package uitleen.uitleensysteemback.controllers.lend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.lend.create.CreateLendRequest;
import uitleen.uitleensysteemback.controllers.lend.create.CreateLendService;
import uitleen.uitleensysteemback.controllers.lend.edit.EditLendRequest;
import uitleen.uitleensysteemback.controllers.lend.edit.EditLendService;
import uitleen.uitleensysteemback.controllers.lend.paged.PagedLendResponse;
import uitleen.uitleensysteemback.controllers.lend.paged.PagedLendService;
import uitleen.uitleensysteemback.models.PagedResponse;

@RestController
@RequestMapping("/lends")
public class LendController {
    private final CreateLendService createLendService;
    private final PagedLendService pagedLendService;
    private final EditLendService editLendService;

    @Autowired
    public LendController(CreateLendService createLendService, PagedLendService pagedLendService, EditLendService editLendService) {
        this.createLendService = createLendService;
        this.pagedLendService = pagedLendService;
        this.editLendService = editLendService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createLend(@RequestBody CreateLendRequest request) {
        createLendService.createLend(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paged")
    public PagedResponse<PagedLendResponse> getPagedLends(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "20") final int size,
            @RequestParam(defaultValue = "id") final String sortBy,
            @RequestParam(defaultValue = "asc") final String sortDir)  {
        return pagedLendService.getPagedLends(page, size, sortBy, sortDir);
    }

    @PutMapping("/{lendId}")
    public ResponseEntity<HttpStatus> editLend(@PathVariable final long lendId, @RequestBody final EditLendRequest request) {
        editLendService.editLend(lendId, request);
        return ResponseEntity.ok().build();
    }

}
