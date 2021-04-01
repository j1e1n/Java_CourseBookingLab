package com.example.codeclan.CourseBookingLab;

import com.example.codeclan.CourseBookingLab.models.Booking;
import com.example.codeclan.CourseBookingLab.models.Course;
import com.example.codeclan.CourseBookingLab.models.Customer;
import com.example.codeclan.CourseBookingLab.repositories.BookingRepository;
import com.example.codeclan.CourseBookingLab.repositories.CourseRepository;
import com.example.codeclan.CourseBookingLab.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingLabApplicationTests {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateCourse(){
		Course course = new Course("Java for Dummies", "Glasgow", 3);
		courseRepository.save(course);

		Customer customer = new Customer("Bob", "Glasgow", 70);
		customerRepository.save(customer);

		Booking booking = new Booking("01-04-2021", customer, course);
		bookingRepository.save(booking);

		customer.addBooking(booking);
		System.out.println(customer.getBookings());
		customerRepository.save(customer);
		assertEquals(1, customer.getBookings().size());


		course.addBooking(booking);
		courseRepository.save(course);
		assertEquals(1, course.getBookings().size());

	}

}
