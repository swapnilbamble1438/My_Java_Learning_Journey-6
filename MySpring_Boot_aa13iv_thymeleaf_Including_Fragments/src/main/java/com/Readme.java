/*
	Including Fragments
	
	1) th:replace
	2) th:insert
	3) th:include
	
	1) th:replace - It will actually substitute the host tag [tag where we
					use replace] by the fragment's. That means, It will remove
					the host tag and in place of host tag, it will add the
					specified fragment including the fragment tag.
					
	2) th:insert - It will simply insert the specified fragment as the body
				   of its host tag including the fragment tag.
				   
	3) th:include - It will also insert the specified fragment as the body
					of its host tag but excluding the fragment tag.


*/