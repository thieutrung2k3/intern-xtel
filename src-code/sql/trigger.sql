CREATE OR REPLACE TRIGGER TRG_PREVENT_DUPLICATE_USERNAME
BEFORE INSERT ON accounts
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    -- Kiểm tra số lượng tài khoản với username giống nhau
    SELECT COUNT(*) INTO v_count
    FROM accounts
    WHERE username = :NEW.username;
    
    -- Nếu đã tồn tại tài khoản với username đó, raise lỗi
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Tên tài khoản đã tồn tại!');
    END IF;
END;
