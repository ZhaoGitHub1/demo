package com.yizhu.listener;
 
import java.lang.reflect.Field;

import com.yizhu.annotation.AutoIncKey;
import com.yizhu.entity.SequenceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class SaveEventListener extends AbstractMongoEventListener<Object> {
 
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		Object source = event.getSource();
		if (source != null) {
			ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
				@Override
				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
					ReflectionUtils.makeAccessible(field);
					// 如果字段添加了我们自定义的AutoIncKey注解
					if (field.isAnnotationPresent(AutoIncKey.class)) {
						// 设置自增ID
						field.set(source, getNextId(source.getClass().getSimpleName()));
					}
				}
			});
		}
	}

	private Long getNextId(String collName) {
		Query query = new Query(Criteria.where("collName").is(collName));
		Update update = new Update();
		update.inc("seqId", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.upsert(true);
		options.returnNew(true);
		SequenceId seq = mongoTemplate.findAndModify(query, update, options, SequenceId.class);
		return seq.getSeqId();
	}
}
