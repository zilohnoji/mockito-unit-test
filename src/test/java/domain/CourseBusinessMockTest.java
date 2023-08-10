package domain;

import com.donatoordep.services.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness courseBusiness;

    @BeforeEach
    void setup() {
        mockService = mock(CourseService.class);
        courseBusiness = new CourseBusiness(mockService);
    }

    @ParameterizedTest
    @MethodSource()
    void testRetrieveCoursesRelatedToSpring_When_UsingAMock(List<String> courses) {

        // Given / Arrange
        when(mockService.retrieveCourse("Leandro")).thenReturn(courses);

        // When / Act
        List<String> filteredCourses = courseBusiness.retriveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertEquals(4, filteredCourses.size(),
                () -> "Filter size don´t returned four courses");
    }

    static Stream<Arguments> testRetrieveCoursesRelatedToSpring_When_UsingAMock(){
        return Stream.of(
                Arguments.of(Arrays.asList(
                        "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                        "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                        "Spotify Engineering Culture Desmistificado",
                        "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                        "Docker do Zero à Maestria - Contêinerização Desmistificada",
                        "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                        "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                        "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                        "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                        "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                        "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"))
        );
    }
}
