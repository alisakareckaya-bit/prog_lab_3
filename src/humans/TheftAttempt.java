package humans;

import transports.ShortyCars;

public record TheftAttempt(Shorties thief, ShortyCars car, boolean success) {
}
