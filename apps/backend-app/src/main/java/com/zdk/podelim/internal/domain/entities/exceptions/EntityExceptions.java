package com.zdk.podelim.internal.domain.entities.exceptions;

public class EntityExceptions {
    public static final String EVENT_NAME_CANNOT_BE_BLANK = "Event name can't be blank";
    public static final String EVENT_CANNOT_EXPIRES_BEFORE_CREATION = "expiresAt cant't be before createdAt";

    public static final String EXPENSE_AMOUNT_CANNOT_BE_NEGATIVE = "amount can't be less than 0";

    public static final String EXPENSECONSUMER_ID_MUST_BE_POSITIVE = "IDs must be positive";

    public static final String PARTICIPANT_NAME_CANNOT_BE_BLANK = "Participant name can't be blank";
}
