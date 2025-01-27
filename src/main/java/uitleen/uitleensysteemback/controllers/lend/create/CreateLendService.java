package uitleen.uitleensysteemback.controllers.lend.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.lend.LendRepository;
import uitleen.uitleensysteemback.entities.Lend;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class CreateLendService {
    private final LendRepository lendRepository;

    @Autowired
    public CreateLendService(LendRepository lendRepository) {
        this.lendRepository = lendRepository;
    }

    public void createLend(CreateLendRequest request) {
        lendRepository.save(mapRequestToLend(request));
    }

    private Lend mapRequestToLend(CreateLendRequest request) {
        Lend lend = new Lend();
        lend.setAccountId(request.getAccountId());
        lend.setItemId(request.getItemId());
        lend.setLendDate(LocalDateTime.now());
        return lend;
    }
}
