package com.gdb.service;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TransferService {

    public TransferService() {
    }

    public void transfer(IAccount from, IAccount to, double amount, int pin)
            throws AccountException,
                   InactiveAccountException,
                   InvalidPinException,
                   InsufficientBalanceException,
                   InvalidAmountException {
        // ============================================================
        // 📝 STEP 1: Transfer Funds With Daily Limit
        //
        // INSTRUCTIONS:
        //   1. Null check: if from or to is null, throw new AccountException("Source and destination accounts are required").
        //   2. Active check: if !from.isActive() or !to.isActive(), throw new InactiveAccountException("Both accounts must be active to transfer funds").
        //   3. PIN verify: if !from.verifyPin(pin), throw new InvalidPinException("Incorrect PIN").
        //   4. Balance check: if !from.canWithdraw(amount), throw new InsufficientBalanceException("Insufficient balance for transfer of Rs. " + amount).
        //   5. Daily-limit check: Account source = (Account) from; call source.resetDailyTransferIfNeeded();
        //      if !source.canTransfer(amount), throw new AccountException("Daily transfer limit exceeded. Remaining today: Rs. " + source.getRemainingDailyTransferLimit()).
        //   6. Debit: from.withdraw(amount, pin).
        //   7. Credit: to.deposit(amount).
        //   8. Update total: source.updateDailyTransferTotal(amount).
        //
        // HINT: The daily-limit methods live on Account, not IAccount, so cast the sender to Account.
        //       Keep the checks in this order: nothing may move until every check has passed.
        // ============================================================

        // Step 1: Check that both accounts exist
        if (from == null || to == null) {
            throw new AccountException(
                    "Source and destination accounts are required"
            );
        }

        // Step 2: Both accounts must be active
        if (!from.isActive() || !to.isActive()) {
            throw new InactiveAccountException(
                    "Both accounts must be active to transfer funds"
            );
        }

        // Step 3: Verify the sender's PIN
        if (!from.verifyPin(pin)) {
            throw new InvalidPinException("Incorrect PIN");
        }

        // Step 4: Check sender's available balance
        if (!from.canWithdraw(amount)) {
            throw new InsufficientBalanceException(
                    "Insufficient balance for transfer of Rs. " + amount
            );
        }

        // Step 5: Check the sender's daily transfer limit
        Account source = (Account) from;

        source.resetDailyTransferIfNeeded();

        if (!source.canTransfer(amount)) {
            throw new AccountException(
                    "Daily transfer limit exceeded. Remaining today: Rs. "
                    + source.getRemainingDailyTransferLimit()
            );
        }

        // Step 6: Debit money from the sender
        from.withdraw(amount, pin);

        // Step 7: Credit money to the receiver
        to.deposit(amount);

        // Step 8: Record the transferred amount against today's limit
        source.updateDailyTransferTotal(amount);
    }
}