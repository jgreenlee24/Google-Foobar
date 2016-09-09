import unittest

# returns index for nearest value in array
def find_nearest(array, value):
    n = [abs(i-value) for i in array]
    idx = n.index(min(n))
    return idx

def answer(document, searchTerms):
    # document: string - words to be searched
    # searchTerms: array - strings to be matched in document

    indices = []

    # create index array for each search term & append to one array:
    for st in searchTerms:
        indices.append([i for i, t in enumerate(document.split()) if t == st])

    # create pointer for each array in indices
    pnts = []
    for i in indices:
        pnts.append(0)

    # find minimum array (array with lowest starting value)
    minval = indices[0][0]
    minptr = 0
    for i, arr in enumerate(indices):
        if indices[i][0] < minval:
            minval = arr[0]
            minptr = i

    # loop: for every value in minimum array
    bestsubstr = ""
    bestlen = 0
    for m, val in enumerate(indices[minptr]):
        # set each pointer to next closest value in every other array
        for x, arr in enumerate(indices):
            if x != minptr:
                pnts[x] = find_nearest(arr, val)
            # update main pointer
            else:
                pnts[x] = m

        # add indices's values @ each pointer to new array
        pntvals = []
        for i, val in enumerate(pnts):
            pntvals.append(indices[i][val])

        # get difference between highest and lowest values
        diff = max(pntvals) - min(pntvals)

        # set best substring if better diff found
        if bestlen == 0 or diff < bestlen:
            bestlen = diff
            bestsubstr = " ".join(document.split()[min(pntvals):max(pntvals)+1])

        # print min(pntvals), max(pntvals), ' : ', bestsubstr
    # until: end of minimum array reached

    # return: string - shortest snippet containing all searchTerms
    return bestsubstr


class test1(unittest.TestCase):
    # Inputs:
    #     (string) document = "many google employees can program"
    #     (string list) searchTerms = ["google", "program"]
    # Output:
    #     (string) "google employees can program"
    def test_default(self):
        doc = "many google employees can program"
        search = ["google", "program"]
        self.assertEqual(answer(doc, search), "google employees can program")

    # test: returns best of 2 options
    def test_abcda(self):
        doc = "a b c d a"
        search = ["a", "c", "d"]
        self.assertEqual(answer(doc, search), "c d a")

    # test: returns minimum window test from leetCode
    def test_banc(self):
        doc = "a d o b e c o d e b a n c"
        search = ["a", "b", "c"]
        self.assertEqual(answer(doc, search), "b a n c")

    # test: mental challenge used to figure out answer
    def test_challenge(self):
        doc = "a a a d b o c b e d c o a d e b b a c a n c b"
        search = ["a", "b", "c"]
        self.assertEqual(answer(doc, search), "b a c")

    # test: returns first best substring
    def test_hello_world(self):
        doc = "world there hello hello where world"
        search = ["hello", "world"]
        self.assertEqual(answer(doc, search), "world there hello")

if __name__ == '__main__':
    unittest.main(verbosity=2)
