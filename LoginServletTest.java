package com.day7.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.day7.dao.BugDAO;
import com.day7.model.Bug;

public class LoginServletTest {
    private BugDAO bugDAO = new BugDAO();

    @Test
    public void testCreateBug() {
        Bug bug = new Bug("Sample Bug", "Description of the sample bug");
        bugDAO.create(bug);
        Bug retrievedBug = bugDAO.findById(bug.getBugId());

        assertEquals(bug.getTitle(), retrievedBug.getTitle());
        assertEquals(bug.getDescription(), retrievedBug.getDescription());
    }
}
