<template>
  <div class="container">
    <h2>金融商品喜好紀錄系統</h2>

    <!-- 新增喜好表單 -->
    <form @submit.prevent="addLike">
      <select v-model.number="form.productId" required>
        <option value="">請選擇商品</option>
        <option v-for="p in products" :key="p.no" :value="p.no">{{ p.productName }}</option>
      </select>
      <input v-model.number="form.orderQuantity" type="number" placeholder="購買數量" required />
      <button type="submit">新增喜好</button>
    </form>

    <!-- 新增商品區塊 -->
    <h3 style="margin-top: 2rem;">新增金融商品</h3>
    <form @submit.prevent="addProduct">
      <input v-model="productForm.productName" placeholder="商品名稱" required />
      <input v-model.number="productForm.price" type="number" placeholder="價格" required />
      <input v-model.number="productForm.feeRate" type="number" placeholder="手續費率" required />
      <button type="submit">新增商品</button>
    </form>

    <!-- 喜好清單 -->
    <table>
      <thead>
        <tr>
          <th>商品名稱</th><th>價格</th><th>手續費率</th><th>帳號</th><th>Email</th><th>數量</th><th>手續費</th><th>總金額</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in likes" :key="item.sn">
          <td>{{ item.productName }}</td>
          <td>{{ item.price }}</td>
          <td>{{ item.feeRate }}</td>
          <td>{{ item.account }}</td>
          <td>{{ item.email }}</td>
          <td>{{ item.orderQuantity }}</td>
          <td>{{ item.totalFee }}</td>
          <td>{{ item.totalAmount }}</td>
          <td>
            <input v-if="editSn === item.sn" v-model.number="editForm.orderQuantity" type="number" />
            <button v-if="editSn === item.sn" @click="saveEdit(item.sn)">儲存</button>
            <button v-else @click="startEdit(item)">編輯</button>
            <button @click="remove(item.sn)">刪除</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { getLikes, createLike, deleteLike, updateLike } from '@/api/likes'

const likes = ref([])
const products = ref([])

const form = ref({
  userId: 'A1236456789', // 無登入，預設 userId
  productId: '',
  orderQuantity: 1
})

const productForm = ref({
  productName: '',
  price: 0,
  feeRate: 0
})

const editSn = ref(null)
const editForm = ref({})

// 喜好操作
const fetchLikes = async () => {
  const res = await getLikes()
  likes.value = res.data
}
const addLike = async () => {
  if (!form.value.productId) return alert('請選擇商品')
  await createLike(form.value)
  form.value.productId = ''
  form.value.orderQuantity = 1
  fetchLikes()
}
const remove = async (sn) => {
  await deleteLike(sn)
  fetchLikes()
}
const startEdit = (item) => {
  editSn.value = item.sn
  editForm.value = { orderQuantity: item.orderQuantity }
}
const saveEdit = async (sn) => {
  await updateLike(sn, editForm.value)
  editSn.value = null
  fetchLikes()
}

// 商品操作
const fetchProducts = async () => {
  const res = await axios.get('/api/products')
  products.value = res.data
}
const addProduct = async () => {
  await axios.post('/api/products', productForm.value)
  productForm.value = { productName: '', price: 0, feeRate: 0 }
  alert('商品新增成功')
  fetchProducts()
}

onMounted(() => {
  fetchLikes()
  fetchProducts()
})
</script>

<style scoped>
.container {
  padding: 1rem;
}
input, select {
  margin: 0.3rem;
}
table {
  width: 100%;
  margin-top: 1.5rem;
  border-collapse: collapse;
}
th, td {
  border: 1px solid #aaa;
  padding: 0.5rem;
}
</style>
