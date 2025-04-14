CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(100) NOT NULL,
    hire_date DATE DEFAULT SYSDATE,
    salary NUMBER(10,2),
    dept_id NUMBER
);

-- Thêm 10 nhân viên vào bảng employees
INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(1, 'Nguyễn Văn A', TO_DATE('15-03-2019', 'DD-MM-YYYY'), 8500, 10);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(2, 'Trần Thị B', TO_DATE('22-07-2020', 'DD-MM-YYYY'), 7200, 20);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(3, 'Lê Văn C', TO_DATE('10-11-2018', 'DD-MM-YYYY'), 9500, 10);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(4, 'Phạm Thị D', TO_DATE('05-01-2021', 'DD-MM-YYYY'), 6800, 30);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(5, 'Hoàng Văn E', TO_DATE('18-09-2017', 'DD-MM-YYYY'), 11000, 20);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(6, 'Vũ Thị F', TO_DATE('30-05-2022', 'DD-MM-YYYY'), 5500, 10);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(7, 'Đặng Văn G', TO_DATE('12-12-2019', 'DD-MM-YYYY'), 7800, 30);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(8, 'Bùi Thị H', TO_DATE('25-04-2020', 'DD-MM-YYYY'), 6200, 20);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(9, 'Mai Văn I', TO_DATE('08-08-2021', 'DD-MM-YYYY'), 5900, 10);

INSERT INTO employees (emp_id, emp_name, hire_date, salary, dept_id) VALUES
(10, 'Lý Thị K', TO_DATE('14-02-2023', 'DD-MM-YYYY'), 4800, 30);

COMMIT;

SELECT * FROM employees;

