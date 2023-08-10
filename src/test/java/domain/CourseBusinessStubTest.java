package domain;

import com.donatoordep.services.CourseService;
import com.donatoordep.services.stubs.CourseServiceStub;
import domain.CourseBusiness;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourseBusinessStubTest {

    @Test
    void testRetrieveCoursesRelatedToSpring_When_UsingAStub() {
        // Given / Arrange
        CourseService service = new CourseServiceStub();
        CourseBusiness courseBusiness = new CourseBusiness(service);

        // When / Act
        List<String> filteredCourses = courseBusiness.retriveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertEquals(4, filteredCourses.size(),
                () -> "Filter size don´t returned four courses");
    }

    @Test
    void testRetrieveCoursesRelatedToSpring_When_UsingFooBarStudent() {
        // Given / Arrange
        CourseService service = new CourseServiceStub();
        CourseBusiness courseBusiness = new CourseBusiness(service);

        // When / Act
        List<String> filteredCourses = courseBusiness.retriveCoursesRelatedToSpring("Foo Bar");

        // Then / Assert
        assertEquals(0, filteredCourses.size(),
                () -> "Filter size don´t should return courses");
    }
}
