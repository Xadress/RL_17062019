package ccloader.application.common;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PagedListTest {
	
	@Test
	public void createEmptyPagedList_test() {
		PagedList<Integer> pagedList = new PagedList<>();
		
		assertTrue(pagedList.getPageSize() == 6);
		assertTrue(pagedList.getPageNumber() == 1);
		assertTrue(pagedList.getTotalItems() == 0);
		
	}
	
	@Test
	public void createSimplePagedList_test() {
		List<Integer> numbers = new ArrayList<>();
		for(int i=0; i < 10; i++) {
			numbers.add(new Random().nextInt(10));
		}
		
		PagedList<Integer> pagedList = new PagedList<>(numbers);
		
		assertTrue(pagedList.getList().size() == 6);
		assertTrue(pagedList.getTotalItems() == 10);
	}
	
	
	@Test
	public void numberOfPages_test() {
		
		List<Integer> numbers = new ArrayList<>();
		for(int i=0; i < 15; i++) {
			numbers.add(new Random().nextInt(10));
		}
		
		PagedList<Integer> pagedList = new PagedList<>(numbers);
		
		assertTrue(pagedList.getNumberOfPages()==3);
		
		pagedList.setPageSize(3);
		
		assertTrue(pagedList.getNumberOfPages()==5);
		
		pagedList.setPageSize(1);
		
		assertTrue(pagedList.getNumberOfPages()==15);
		
		pagedList.setPageSize(0);
		
		assertTrue(pagedList.getNumberOfPages()==15);
		
		pagedList.setPageSize(Integer.MAX_VALUE);
		
		assertTrue(pagedList.getNumberOfPages()==1);
	}
	
	@Test 
	public void pageChange_test() {
		List<Integer> numbers = new ArrayList<>();
		for(int i=0; i < 15; i++) {
			numbers.add(new Random().nextInt(10));
		}
		
		PagedList<Integer> pagedList = new PagedList<>(numbers);
		
		List<Integer> page1 = new ArrayList<>();
		page1.addAll(pagedList.getList());
		
		pagedList.setPageNumber(2);
		
		List<Integer> page2 = new ArrayList<>();
		page2.addAll(pagedList.getList());
		
		assertTrue(!page1.equals(page2));
		
		pagedList.setPageNumber(3);
		
		List<Integer> page3 = new ArrayList<>();
		page3.addAll(pagedList.getList());
		
		assertTrue(!page1.equals(page3));
		assertTrue(!page2.equals(page3));
		assertTrue(page3.size() == pagedList.getList().size());
	}

}
