package com.ddubson.cassandra.v1.controllers;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.ddubson.cassandra.v1.models.UserStatusUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddubson on 1/23/16.
 */
@RestController
public class BaseController {
	@Autowired
	Cluster cluster;

	@RequestMapping("/")
	public List<UserStatusUpdate> index() {
		Session session = cluster.connect("my_status");
		ResultSet rs = session.execute("SELECT * FROM user_status_updates");
		List<UserStatusUpdate> updates = new ArrayList<>();
		rs.forEach(row -> {
			UserStatusUpdate update = new UserStatusUpdate();
			update.username = row.getString("username");
			update.id = row.getUUID("id");
			update.body = row.getString("body");
			updates.add(update);
		});
		return updates;
	}
}
