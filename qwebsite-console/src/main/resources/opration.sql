#插入手工数据
INSERT INTO t_credentials (
	credentials_id,
	credentials_type,
	credentials_level,
	credentials_date,
	`name`,
	person_no,
	card_no,
	work_unit,
	trainer_type,
	gmt_create
)
VALUES
	(
		'20181001010228',
		2,
		3,
		'2018-08-15 00:00:00',
		'张三',
		'NONE',
		'321081199408187823',
		'江苏省扬州市仪征市仪征化纤白沙社区',
		'1',
		SYSDATE()
	)

#删除某时间点之后的数据
#DELETE from t_credentials where gmt_create > '2018-08-23 10:44:26'

#清除重复数据
DELETE from t_credentials where id IN( 
	SELECT a.id from 
		(SELECT id FROM t_credentials  WHERE  (credentials_type, credentials_level, card_no, trainer_type) 
	IN (SELECT t.credentials_type, t.credentials_level, t.card_no, t.trainer_type FROM t_credentials t 
			GROUP BY t.credentials_type, t.credentials_level, t.card_no, t.trainer_type 
			HAVING count(*) > 1 
	) AND id NOT IN 
		( SELECT max(id) FROM t_credentials GROUP BY credentials_type, credentials_level, card_no, trainer_type HAVING COUNT(*) > 1 )
	) a
)