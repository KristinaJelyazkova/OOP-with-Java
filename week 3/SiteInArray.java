public class SiteInArray {
    // finds all indexes at which sites start and the lengths of the sites
    // returns number of sites
    public static int allSites(int[] sortedArray, int[] startIndexSite, int[] lengthSite){
        // if the array is empty or has 1 element - no sites
        if(sortedArray.length <= 1){
            return 0;
        }

        int currentRepetitiveElement = sortedArray[0];
        startIndexSite[0] = 0;
        int counterSites = 0;

        for (int i = 1; i < sortedArray.length; i++) {

            if(sortedArray[i] != currentRepetitiveElement) {

                /* if we have found at least 2 equal numbers and the current
                number is not equal then we have reached the end of a site*/
                if(startIndexSite[counterSites] < i - 1){
                    lengthSite[counterSites] = i - startIndexSite[counterSites];
                    counterSites++;
                }

                // a new site starts
                startIndexSite[counterSites] = i;
                currentRepetitiveElement = sortedArray[i];
            }

        }

        // check for a site at the end
        int last = sortedArray.length - 1;
        if(sortedArray[last] == sortedArray[last - 1]){
            lengthSite[counterSites] = last - startIndexSite[counterSites] + 1;
            counterSites++;
        }

        // returns true if there are any sites
        return counterSites;
    }
}
