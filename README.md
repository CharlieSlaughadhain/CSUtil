# CSUtils

Includes method truncate that doesn't come standard with Java.

More to come.

Truncate:
    - CSUtil.trunc(5.095, 2) returns "5.10". Includes the last 0 by default
    - CSUtil.trunc(5.095, 2, false) returns "5.1".
    - CSUtil.trunc(5.095, 0) returns "5".

Currency:
    - CSUtil.toCurrency(99999999999.99, "$") returns a String of "$99,999,999,999.99"
