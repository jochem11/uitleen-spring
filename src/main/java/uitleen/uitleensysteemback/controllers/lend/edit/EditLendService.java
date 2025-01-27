package uitleen.uitleensysteemback.controllers.lend.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.lend.LendRepository;
import uitleen.uitleensysteemback.entities.Lend;

@Service
public class EditLendService {
    private final LendRepository lendRepository;

    @Autowired
    public EditLendService(LendRepository lendRepository) {
        this.lendRepository = lendRepository;
    }

    public void editLend(final long lendId, final EditLendRequest request) {
        final Lend lend = lendRepository.findById(lendId).orElseThrow(() -> new IllegalArgumentException("Lend not found"));
        final Lend updatedLend = mapRequestToLend(lend, request);
        lendRepository.save(updatedLend);
    }

    private Lend mapRequestToLend(Lend lend, EditLendRequest request) {
        lend.setAccountId(request.getAccountId());
        lend.setItemId(request.getItemId());
        lend.setLendDate(request.getLendDate());
        lend.setReturnDate(request.getReturnDate());
        return lend;
    }
}
