--데이터의 작업이 짧게 걸리는 시간 순서대로 1부터 15까지의 순위를 
--매겨서 출력하시오.



SELECT * FROM t_worktime;

SELECT
            workcd_vc,  time_nu
           ,rank() over(order by time_nu) rnk
  FROM t_worktime;
  
--outer join
--테이블 관계 이용해서 문제를 풀어본다  
  
SELECT * FROM t_worktime
WHERE rownum < 4;  

--카타시안 곱(15*15=225)

SELECT
            *
  FROM t_worktime a,  t_worktime b;
  
  SELECT
            *
  FROM t_worktime a,  t_worktime b
 WHERE a.time_nu >= b.time_nu;
 
   SELECT
            count(*)
  FROM t_worktime a,  t_worktime b
 WHERE a.time_nu >= b.time_nu;
 
    SELECT
            count(*)
  FROM t_worktime a,  t_worktime b
 WHERE a.time_nu >= b.time_nu;
 
 
     SELECT
            a.workcd_vc,
            a.time_nu,
            count(*)
  FROM t_worktime a,  t_worktime b
 WHERE a.time_nu >= b.time_nu;
 
      SELECT
            a.workcd_vc,
            a.time_nu,
            count(*)
  FROM t_worktime a,  t_worktime b
 WHERE a.time_nu >= b.time_nu
GROUP BY a.workcd_vc, a.time_nu;

      SELECT
            a.workcd_vc,
            a.time_nu,
            count(*)
  FROM t_worktime a,  t_worktime b
 WHERE a.time_nu >= b.time_nu
GROUP BY a.workcd_vc, a.time_nu
ORDER BY count(*);

SELECT
             workcd_vc, time_nu
  FROM t_worktime
ORDER BY time_nu asc;

SELECT rownum rno,
             workcd_vc, time_nu
  FROM t_worktime
ORDER BY time_nu asc;

SELECT
             rownum rno, workcd_vc, time_nu
   FROM (
                SELECT 
                             workcd_vc, time_nu
                  FROM t_worktime
                ORDER BY time_nu asc  
              );
              
SELECT rownum  rno FROM emp;              
 
 
SELECT
            ename,sum(sal)
  FROM emp;
  
SELECT
            ename,sum(sal)
  FROM emp 
GROUP BY ename;  

SELECT
            deptno,sum(sal)
  FROM emp 
GROUP BY deptno;  