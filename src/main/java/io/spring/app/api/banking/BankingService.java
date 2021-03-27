package io.spring.app.api.banking;

public interface BankingService {
    /**
     * This return id of bill
     * @param request
     * @return long
     */
    long processBanking(BankingRequest request);
}
