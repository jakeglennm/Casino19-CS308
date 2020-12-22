package myProject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import myProject.GamePieces.Card;
import myProject.GamePieces.Hand;

@RunWith(MockitoJUnitRunner.class)
public class HandTests {

	@Mock
	Card mockCard1 = mock(Card.class);
	
	@Mock
	Card mockCard2 = mock(Card.class);
	
	@Mock
	Card mockCard3 = mock(Card.class);
	
	@Mock
	Card mockCard4 = mock(Card.class);
	
	@Mock
	Card mockCard5 = mock(Card.class);
		
	@Test
	public void testGetPossibleValues() {
		
		when(mockCard1.getValue()).thenReturn(10);
		when(mockCard2.getValue()).thenReturn(9);
		when(mockCard3.getValue()).thenReturn(2);
		when(mockCard4.getValue()).thenReturn(0);
		when(mockCard5.getValue()).thenReturn(0);

		ArrayList<Card> mockCards = new ArrayList<Card>(Arrays.asList(mockCard1, mockCard2, mockCard3, mockCard4, mockCard5));
		
		Hand testHand = new Hand(mockCards);
		testHand.setCards(mockCards);
		
		assertEquals( 1, testHand.getPossibleValues().size());
		assertEquals( 21, testHand.getPossibleValues().get(0).intValue());

	}
	
	@Test
	public void testGetPossibleValues1Ace() {
		
		when(mockCard1.getValue()).thenReturn(10);
		when(mockCard2.getValue()).thenReturn(9);
		when(mockCard3.getValue()).thenReturn(1);
		when(mockCard4.getValue()).thenReturn(0);
		when(mockCard5.getValue()).thenReturn(0);

		ArrayList<Card> mockCards = new ArrayList<Card>(Arrays.asList(mockCard1, mockCard2, mockCard3, mockCard4, mockCard5));
		
		Hand testHand = new Hand(mockCards);
		testHand.setCards(mockCards);
		
		assertEquals( 2, testHand.getPossibleValues().size());
		assertEquals( 20, testHand.getPossibleValues().get(0).intValue());
		assertEquals( 30, testHand.getPossibleValues().get(1).intValue());


	}
	
	
	@Test
	public void testGetPossibleValues2Ace() {
		
		when(mockCard1.getValue()).thenReturn(10);
		when(mockCard2.getValue()).thenReturn(9);
		when(mockCard3.getValue()).thenReturn(1);
		when(mockCard4.getValue()).thenReturn(1);
		when(mockCard5.getValue()).thenReturn(0);

		ArrayList<Card> mockCards = new ArrayList<Card>(Arrays.asList(mockCard1, mockCard2, mockCard3, mockCard4, mockCard5));
		
		Hand testHand = new Hand(mockCards);
		testHand.setCards(mockCards);
		
		assertEquals( 2, testHand.getPossibleValues().size());
		assertEquals( 21, testHand.getPossibleValues().get(0).intValue());
		assertEquals( 31, testHand.getPossibleValues().get(1).intValue());

	}
	
	@Test
	public void testGetPossibleValues3Ace() {
		
		when(mockCard1.getValue()).thenReturn(10);
		when(mockCard2.getValue()).thenReturn(9);
		when(mockCard3.getValue()).thenReturn(1);
		when(mockCard4.getValue()).thenReturn(1);
		when(mockCard5.getValue()).thenReturn(1);

		ArrayList<Card> mockCards = new ArrayList<Card>(Arrays.asList(mockCard1, mockCard2, mockCard3, mockCard4, mockCard5));
		
		Hand testHand = new Hand(mockCards);
		testHand.setCards(mockCards);
		
		assertEquals( 2, testHand.getPossibleValues().size());
		assertEquals( 22, testHand.getPossibleValues().get(0).intValue());
		assertEquals( 32, testHand.getPossibleValues().get(1).intValue());
	}
	
	
	
	@Test
	public void testGetPossibleValues4Ace() {
		
		when(mockCard1.getValue()).thenReturn(10);
		when(mockCard2.getValue()).thenReturn(1);
		when(mockCard3.getValue()).thenReturn(1);
		when(mockCard4.getValue()).thenReturn(1);
		when(mockCard5.getValue()).thenReturn(1);

		ArrayList<Card> mockCards = new ArrayList<Card>(Arrays.asList(mockCard1, mockCard2, mockCard3, mockCard4, mockCard5));
		
		Hand testHand = new Hand(mockCards);
		testHand.setCards(mockCards);
		
		assertEquals( 2, testHand.getPossibleValues().size());
		assertEquals( 14, testHand.getPossibleValues().get(0).intValue());
		assertEquals( 24, testHand.getPossibleValues().get(1).intValue());

	}
	
	
	
	
	
	
}
	