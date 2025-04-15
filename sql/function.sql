CREATE OR REPLACE FUNCTION get_username_func(
    p_account_id IN NUMBER
)RETURN VARCHAR2
IS
    v_username VARCHAR2(10);
BEGIN
    SELECT username INTO v_username
    FROM accounts
    WHERE account_id = p_account_id;
    
    RETURN v_username;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Can not find account.';
    WHEN OTHERS THEN
        RETURN 'SYSTEM ERROR';
END;

SELECT get_username_func(1) AS username FROM dual;

DECLARE
    username VARCHAR2(10);
BEGIN
    username := get_username_func(2);
    DBMS_OUTPUT.PUT_LINE('Username: ' || username);
END;