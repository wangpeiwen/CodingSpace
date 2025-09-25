S = "ADOBECODEBANC"
T = "ABC"

t_dict = {}

for a in T:
    if not a in t_dict:
        t_dict[a] = 0

s_dict = {}
# for idx, a in enumerate(S):
#     if a not in s_dict:
#         s_dict[a] = 1
#     else:
#         s_dict[a] = s_dict[a] + 1

i = 0
j = 0

res_i = 0
res_j = 0
idx_list = []

result = -1
while True:
    if j >= len(S) or i >= len(S):
        break
    if S[j] not in t_dict:
        j = j + 1
        continue

    idx_list.append(j)
    print(idx_list)

    if S[j] not in s_dict:
        s_dict[S[j]] = 1
    else:
        s_dict[S[j]] = s_dict[S[j]] + 1

    print(s_dict)

    if len(s_dict) < len(t_dict):
        j = j + 1
        continue

    while True:
        char = S[idx_list[i]]
        if s_dict[char] <=1:
            break
        s_dict[char] = s_dict[char] - 1
        i = i + 1
    
    if result == -1:
        result = j - idx_list[i] + 1
        res_i = idx_list[i]
        res_j = j
    else:
        if j - idx_list[i] + 1 < result:
            result = j - idx_list[i] + 1
            res_i = idx_list[i]
            res_j = j

    j = j + 1

print(result)
print(S[res_i:res_j+1])

    



